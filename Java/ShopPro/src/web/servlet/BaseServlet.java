package web.servlet;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@javax.servlet.annotation.WebServlet(name = "BaseServlet", urlPatterns = "/BaseServlet")
public class BaseServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //得到action的名称(方法的名称)
        String actionName = request.getParameter("action");
        //通过action的名称得到method对象
        Method method = getMethodByActionName(actionName);
        if (method != null) {
            //在调用方法前做一些处理
            executeOper(method, request, response);

        } else {
            System.out.println("没有该方法: " + actionName);
        }
    }

    //在调用方法前做一些处理
    private void executeOper(Method method, HttpServletRequest request, HttpServletResponse response) {
        //得到方法中的参数个数
        int parameterCount = method.getParameterCount();
        //定一个数组，这个数组用来装已经赋好值的参数
        Object[] parameterArray = new Object[parameterCount];
        //给方法参数赋值
        paramOper(method, parameterArray, request, response);
        //调用方法
        try {
            Object result = method.invoke(this, parameterArray);
            //跳转视图
            if (result!=null) {
                responseView(result.toString(), request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //跳转视图
    private void responseView(String result, HttpServletRequest request, HttpServletResponse response) {
        Map<String, String> map = spilt(result);
        String type = map.get("type");
        String view = map.get("view");
        if ("forward".equals(type)) {
            //转发方式跳转
            try {
                request.getRequestDispatcher(view).forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if ("redirect".equals(type)) {
            //重定向的方式
            try {
                response.sendRedirect(view);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //对返回的结果进行拆分
    private Map<String, String> spilt(String result) {
        Map<String, String> map = new HashMap<>();
        String[] strings = result.split(":");
        map.put("type", strings[0]);
        map.put("view", strings[1]);
        return map;
    }

    //给方法参数赋值
    private void paramOper(Method method, Object[] parameterArray, HttpServletRequest request,
                           HttpServletResponse response) {
        //得到方法的所有参数
        Parameter[] parameters = method.getParameters();
        //得到方法中所有参数的名称
        LocalVariableTableParameterNameDiscoverer nameDiscoverer = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = nameDiscoverer.getParameterNames(method);

        for (int i = 0; i < parameters.length; i++) {
            //HttpservletRequest
            String typeName = parameters[i].getType().getSimpleName();
            if ("HttpServletRequest".equals(typeName)) {
                parameterArray[i] = request;
            } else if ("HttpServletResponse".equals(typeName)) {
                parameterArray[i] = response;
            } else if ("String".equals(typeName)) {
                String name = parameterNames[i];
                String value = request.getParameter(name);
                parameterArray[i] = value;
            } else if ("Integer".equals(typeName)) {
                String name = parameterNames[i];
                String value = request.getParameter(name);
                parameterArray[i] = Integer.parseInt(value);
            } else {
                //自定义对象
                try {
                    //创建了一个对象
                    Object objParam = parameters[i].getType().newInstance();
                    //获取请求参数的数据
                    Map<String, String[]> parameterMap = request.getParameterMap();

                    //把Map<String,String[]>转成Map<String,object>
                    Map<String, Object> objectMap = converStringArrayToObject(parameterMap);

                    //通过beanutils给对象的属性赋值
                    BeanUtils.populate(objParam, objectMap);

                    //把对象放到array中
                    parameterArray[i] = objParam;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.err.print("创建对象失败! " + parameters[i].getType());
                }
            }
        }

    }

    //把Map<String,String[]>转成Map<String,object>
    private Map<String, Object> converStringArrayToObject(Map<String, String[]> parameterMap) {
        Map<String, Object> objectMap = converStringToObject(parameterMap);

        //处理日期
        DateConver(objectMap);
        return objectMap;
    }

    //处理日期
    private void DateConver(Map<String, Object> objectMap) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        //遍历map
        Set<Map.Entry<String, Object>> entrySet = objectMap.entrySet();
        for (Map.Entry<String, Object> entry : entrySet) {
            String value = entry.getValue().toString();//1990-11-19  1990/11/19
            if (value.contains("-") || value.contains("/")) {
                try {
                    Date date = sdf.parse(value);
                    //重新覆盖value的值
                    entry.setValue(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Map<String, Object> converStringToObject(Map<String, String[]> parameterMap) {
        Map<String, Object> objectMap = new HashMap<String, Object>();
        //遍历map
        Set<Map.Entry<String, String[]>> entrySet = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entrySet) {

            objectMap.put(entry.getKey(), entry.getValue()[0]);
        }
        return objectMap;
    }

    //通过action的名称得到method对象
    private Method getMethodByActionName(String actionName) {
        //得到类中所有的public方法
        Method[] methods = this.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().equals(actionName)) {
                return method;
            }
        }
        return null;
    }
}
