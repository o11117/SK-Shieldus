numbers1 = [2, 4, 6, 8, 10]
numbers2 = [1, 3, 5, 7, 12]
print(f'숫자 리스트: {numbers1}\n모든 수가 짝수인가? {all(num % 2 == 0 for num in numbers1)}\n하나라도 10보다 큰 수가 있는가? {any(num > 10 for num in numbers1)}')
print(f'숫자 리스트: {numbers2}\n모든 수가 짝수인가? {all(num % 2 == 0 for num in numbers2)}\n하나라도 10보다 큰 수가 있는가? {any(num > 10 for num in numbers2)}')
