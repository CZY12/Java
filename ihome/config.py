# coding:utf-8


import redis

class Config(object):
    """配置信息"""
    DEBUG = True

    SECRET_KEY = "XHSOI*Y9dfs9cshd9"

    # 数据库
    SQLALCHEMY_DATABASE_URI = "mysql+pymysql://root:czy@127.0.0.1:3306/ihome"
    SQLALCHEMY_TRACK_MODIFICAIONS = True

    # redis
    REDIS_HOST = "127.0.0.1"
    REDIS_PORT = 6379

    # flask_session配置
    SESSION_TYPE = "redis"
    SESSION_REDIS = redis.StrictRedis(host=REDIS_HOST, port=REDIS_PORT)
    SECRET_USE_SIGNER = True  # 对cookie中的session_id进行隐藏处理
    PERMANENT_SESSION_LIFETIME = 86400  # session数据的有效期，单位：秒


class DevelopmentConfig(Config):
    """开发模式的配置信息"""

    DEBUG = True


class ProductionConfig(Config):
    """生产环境配置信息"""
    pass


config_map = {
    "develop": DevelopmentConfig,
    "product": ProductionConfig
}
