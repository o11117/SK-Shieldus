import csv

def write_grades_csv(file_path, grades):
    with open(file_path, 'w', newline='', encoding='utf-8') as f:
        writer = csv.writer(f)
        writer.writerow(['이름', '점수'])
        for name, score in grades:
            writer.writerow([name, score])

def read_grades_csv(file_path):
    grades = []
    with open(file_path, 'r', encoding='utf-8') as f:
        reader = csv.reader(f)
        next(reader)  # 헤더 건너뛰기
        for row in reader:
            name, score = row
            grades.append((name, int(score)))
    return grades

grades = [
    ('김철수', 85),
    ('이영희', 92),
    ('박민수', 78),
    ('최수진', 95)
]
file_path = 'grades.csv'

write_grades_csv(file_path, grades)
print('학생 성적이 grades.csv에 저장되었습니다.\n')

read_data = read_grades_csv(file_path)
print('성적 분석 결과:')
for name, score in read_data:
    print(f'{name}: {score}점')
avg = sum(score for _, score in read_data) / len(read_data)
print(f'전체 평균: {avg:.1f}점')
