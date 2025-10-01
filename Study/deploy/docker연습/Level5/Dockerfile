# Python 기본 이미지 사용
FROM python:3.9

# 작업 디렉토리 설정
WORKDIR /app

# 필요한 파일 복사
COPY requirements.txt .
COPY app/ ./app/

# 패키지 설치
RUN pip install -r requirements.txt

# 포트 열기
EXPOSE 8000

# 앱 실행
CMD ["uvicorn", "app.main:app", "--host", "0.0.0.0", "--port", "8000"]