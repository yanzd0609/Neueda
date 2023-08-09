import pandas as pd
import os
import pymysql

db=pymysql.connect(host='127.0.0.1',
                   port=3306,
                   user='root',
                   passwd='c0nygre',
                   db='stock',
                   charset='utf8')
cursor=db.cursor()

for filepath, dirnames,filenames in os.walk(r'dataset'):
    for filename in filenames:
        print(filepath)
        print(filename)
        ngData=pd.read_csv(os.path.join(filepath,filename))
        stock_symbol=os.path.splitext(filename)[0]
        length = len(ngData)
        ngData['stock_symbol']=[stock_symbol]*length
        # ngData.to_csv(os.path.join(filepath,filename),index=False)
        insert_sql = 'insert into stock_record (stock_symbol,date,open,close,high,low,volume) values (%s, %s,%s,%s,%s,%s,%s)'
        for i in range(0,ngData.shape[0]):
            row = ngData.loc[i].values
            cursor.execute(insert_sql,(str(row[8]),str(row[0]),float(row[1]),float(row[4]),float(row[2]),float(row[3]),int(row[5])))

db.commit()
db.close()
cursor.close()
print('end')
        
    