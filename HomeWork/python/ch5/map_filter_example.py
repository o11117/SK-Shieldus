numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

all_squares = list(map(lambda x: x ** 2, numbers))
greater_than_5 = list(filter(lambda x: x > 5, numbers))
squares_gt_5 = list(map(lambda x: x ** 2, filter(lambda x: x > 5, numbers)))

print(f'원본 숫자: {numbers}')
print(f'모든 수의 제곱: {all_squares}')
print(f'5보다 큰 수들: {greater_than_5}')
print(f'5보다 큰 수들의 제곱: {squares_gt_5}')