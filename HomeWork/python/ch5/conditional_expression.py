score = 85
print(f'점수: {score}, 결과: {"합격" if score >= 60 else "불합격"}')

age = 17
print(f'나이: {age}, 상태: {"성인" if age >= 19 else "미성년자"}')

nums = [5, 12, 8, 23, 42, -7, 0]
max_num = nums[0] if nums else None
for n in nums:
    max_num = n if n > max_num else max_num
print(f'숫자들의 최대값: {max_num}')

print(f'양수들: {[n for n in nums if n > 0]}')
