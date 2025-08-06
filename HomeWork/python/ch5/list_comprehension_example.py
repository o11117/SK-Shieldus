num_list = [1,2,3,4,5,6,7,8,9,10]

print(f'원본 리스트: {num_list}\n짝수: {[num for num in num_list if num % 2 == 0]}\n짝수의 제곱: {[num ** 2 for num in num_list if num % 2 == 0]}')