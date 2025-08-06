sum = 0
while 1:
    num = int(input('숫자를 입력하세요 (0을 입력하면 종료): '))
    if num == 0:
        break
    sum += num
print(f'입력한 숫자들의 합: {sum}')