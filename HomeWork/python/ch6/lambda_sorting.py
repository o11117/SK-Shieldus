students = [('김철수', 85), ('이영희', 92), ('박민수', 78), ('최수진', 95)]

print(f'학생 정보: {students}\n이름순 정렬: {sorted(students, key=lambda x: x[0])}\n점수순 정렬: {sorted(students, key=lambda x: x[1])}\n점수 내림차순: {sorted(students, key=lambda x: x[1], reverse=True)}')