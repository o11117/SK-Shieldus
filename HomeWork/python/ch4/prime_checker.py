num = int(input('숫자를 입력하세요: '))
for i in range(1, int(num ** 0.5) + 1):
    if num % i == 0 or num < 2:
        print(f'{num}은(는) 소수가 아닙니다.')
        break
else:
    print(f'{num}은(는) 소수입니다.')