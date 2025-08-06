import datetime

name = "김철수"
age = 25
pi = 3.14159
price = 1234
percentage = 0.855
today = datetime.date(2025, 7, 20)

print(f'이름: {name}, 나이: {age}\n 원주율: {pi:.2f}\n 가격: {price:,}원\n 비율: {percentage:.2%}\n 오늘 날짜: {today:%Y년 %m월 %d일}')