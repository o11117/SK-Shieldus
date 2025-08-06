def greeting(name, message='안녕하세요', ending='!'):
    return f'{message}, {name}님{ending}'

print(greeting('김철수'))
print(greeting('John', message='Hello'))
print(greeting('이영희', ending='! 좋은 하루 되세요!'))
