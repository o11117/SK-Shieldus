# 재귀
def factorial_recursive(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial_recursive(n - 1)

# 반복
def factorial_iterative(n):
    result = 1
    for i in range(2, n + 1):
        result *= i
    return result

print(f'5! (재귀) = {factorial_recursive(5)}')
print(f'5! (반복) = {factorial_iterative(5)}')
print(f'7! (재귀) = {factorial_recursive(7)}')
print(f'7! (반복) = {factorial_iterative(7)}')
