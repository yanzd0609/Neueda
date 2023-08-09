import pymysql

db=pymysql.connect(host='127.0.0.1',
                   port=3306,
                   user='root',
                   passwd='c0nygre',
                   db='stock',
                   charset='utf8')
cursor = db.cursor()

print('connected to database stock')

sql='''CREATE TABLE IF NOT EXISTS stock_record (
    `stock_symbol` CHAR(10),
    `date` CHAR(100),
    `open` FLOAT,
    `close` FLOAT,
    `high` FLOAT,
    `low` FLOAT,
    `volume` BIGINT
    )'''
cursor.execute(sql)
cursor.close()
db.close()    
print('create end')