grades = {'김철수' : 85, '이영희': 92, '박민수': 78, '최수진': 95}
print('학생 성적:')
for key, value in grades.items():
    print(f'{key}: {value}점')
print(f'평균 점수: {sum(grades.values()) / len(grades)}점')