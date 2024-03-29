"""add trade_no column

Revision ID: 052e504f938b
Revises: b1ddcb4df69f
Create Date: 2019-04-10 20:12:05.555010

"""
from alembic import op
import sqlalchemy as sa


# revision identifiers, used by Alembic.
revision = '052e504f938b'
down_revision = 'b1ddcb4df69f'
branch_labels = None
depends_on = None


def upgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.add_column('ih_order_info', sa.Column('trade_no', sa.String(length=80), nullable=True))
    # ### end Alembic commands ###


def downgrade():
    # ### commands auto generated by Alembic - please adjust! ###
    op.drop_column('ih_order_info', 'trade_no')
    # ### end Alembic commands ###
