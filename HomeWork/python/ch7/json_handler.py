import json

def write_json(file_path, data):
    with open(file_path, 'w', encoding='utf-8') as f:
        json.dump(data, f)

def read_json(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        return json.load(f)

# 예시 데이터
data = {
    '이름': '김철수',
    '나이': 25,
    '직업': '개발자',
    '취미': ['독서', '영화감상', '코딩'],
    '주소': '서울시 강남구'
}
file_path = 'data.json'

write_json(file_path, data)
print('데이터가 data.json에 저장되었습니다.\n')

read_data = read_json(file_path)
print('JSON에서 읽어온 데이터:')
for key, value in read_data.items():
    print(f'{key}: {value}')
