def write_lines(file_path, lines):
    with open(file_path, 'w', encoding='utf-8') as f:
        for line in lines:
            f.write(line + '\n')

def read_lines(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        return [line.rstrip('\n') for line in f]

lines_to_write = [
    '안녕하세요',
    '파이썬 파일 처리를 연습하고 있습니다.',
    '오늘은 좋은 날씨입니다.'
]
file_path = 'example.txt'

print(f'파일에 저장할 내용: ')
for line in lines_to_write:
    print(line)
write_lines(file_path, lines_to_write)
read_result = read_lines(file_path)
print('\n파일에서 읽어온 내용:')
for line in read_result:
    print(line)

