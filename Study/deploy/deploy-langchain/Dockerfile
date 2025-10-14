# ---- 빌드 단계: 모든 의존성 설치 ----
# 빌드에 필요한 도구가 포함된 Python 3.12 slim 이미지 사용
FROM python:3.12-slim AS builder

# 컨테이너 내부의 작업 디렉토리를 설정
WORKDIR /app

# 시스템 의존성 설치. 최종 이미지에 포함되지 않으므로 부담 없이 설치
RUN apt-get update && apt-get install -y \
    build-essential \
    curl \
    git \
    && rm -rf /var/lib/apt/lists/*

# pyproject.toml 복사
COPY pyproject.toml ./

# pip로 의존성 설치
# --no-cache-dir을 사용하여 pip 캐시를 남기지 않음
RUN pip install --no-cache-dir \
    "python-dotenv>=1.1.1,<2.0.0" \
    "langchain>=0.3.27,<0.4.0" \
    "langchain-openai>=0.3.35,<0.4.0" \
    "langchain-community>=0.3.31,<0.4.0" \
    "pypdf>=6.1.1,<7.0.0" \
    "gradio>=5.49.1,<6.0.0" \
    "gradio-pdf>=0.0.22,<0.0.23" \
    "chromadb>=1.1.1,<2.0.0"

# ---- 최종 단계: 애플리케이션 실행 ----
# 최종 이미지에 필요한 최소한의 파일만 포함하기 위해 새로운 python:3.12-slim 이미지 사용
FROM python:3.12-slim

# 컨테이너 내부의 작업 디렉토리를 설정
WORKDIR /app

# Python 출력 버퍼링 비활성화 및 모듈 경로 설정
ENV PYTHONUNBUFFERED=1
ENV PYTHONPATH=/app

# 빌드 단계에서 설치한 의존성 복사
COPY --from=builder /usr/local/lib/python3.12/site-packages /usr/local/lib/python3.12/site-packages

# 소스 코드 복사
COPY src/ ./src/

# 업로드된 PDF 파일을 저장할 디렉토리 생성
RUN mkdir -p /app/uploads

# Gradio가 사용하는 포트 노출
EXPOSE 7860

# 보안을 위해 root가 아닌 일반 사용자(appuser)를 생성하고 실행
RUN useradd --create-home --shell /bin/bash appuser && \
    chown -R appuser:appuser /app
USER appuser

# 애플리케이션 실행
CMD ["python", "src/main.py"]
