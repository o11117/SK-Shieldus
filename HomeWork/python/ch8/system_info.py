import os
import sys

# 현재 작업 디렉토리
print(f'현재 작업 디렉토리: {os.getcwd()}')

# Python 버전
print(f'Python 버전: {sys.version.splitlines()[0]}')

# 운영체제
print(f'운영체제: {os.name}')

# 환경 변수 PATH 일부
print(f'환경 변수 PATH 일부: {os.environ.get("PATH", "")[:30]}')

# 파일 경로 정보
file_path = '/Users/username/documents/report.txt'
dirname = os.path.dirname(file_path)
basename = os.path.basename(file_path)
ext = os.path.splitext(file_path)[1]
print('파일 경로 정보:')
print(f'- 디렉토리: {dirname}')
print(f'- 파일명: {basename}')
print(f'- 확장자: {ext}')

# 파일 존재 여부
print(f'파일 존재 여부: {os.path.exists(file_path)}')
