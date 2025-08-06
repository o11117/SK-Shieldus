def create_log_file(file_path, logs):
    with open(file_path, 'w', encoding='utf-8') as f:
        for log in logs:
            f.write(log + '\n')

def filter_logs(file_path, level):
    with open(file_path, 'r', encoding='utf-8') as f:
        return [line.strip() for line in f if f' - {level} - ' in line]

# 예시 로그 데이터
logs = [
    '2025-07-20 09:15:00 - WARNING - 메모리 사용량이 높습니다',
    '2025-07-20 10:30:00 - ERROR - 데이터베이스 연결 실패',
    '2025-07-20 11:45:00 - ERROR - 파일을 찾을 수 없음',
    '2025-07-20 12:00:00 - WARNING - 디스크 공간 부족'
]
file_path = 'log.txt'

create_log_file(file_path, logs)
print('로그 파일이 생성되었습니다.\n')

error_logs = filter_logs(file_path, 'ERROR')
print('ERROR 레벨 로그들:')
for log in error_logs:
    print(log)

print('\nWARNING 레벨 로그들:')
warning_logs = filter_logs(file_path, 'WARNING')
for log in warning_logs:
    print(log)
