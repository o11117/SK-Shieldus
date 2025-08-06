num = [10, 20, 30, 40, 50]

def calculate_statistics(numbers):
    average = sum(numbers) / len(numbers) if numbers else 0
    big = max(numbers)
    small = min(numbers)
    std_dev = (sum((x - average) ** 2 for x in numbers) / len(numbers)-1) ** 0.5 if numbers else 0
    return average, big, small, std_dev

average, big, small, std_dev = calculate_statistics(num)
print(f'숫자들: {num}\n평균: {average:.1f},\n최댓값: {big},\n최솟값: {small},\n표준편차: {std_dev:.2f}')