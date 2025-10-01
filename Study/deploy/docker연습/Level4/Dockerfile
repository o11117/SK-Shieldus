# 단계 1: 베이스 이미지 선택
FROM node:16-alpine

# 단계 2: 메타정보 추가
LABEL maintainer="dev@example.com"
LABEL version="1.0"

# 단계 3: 환경 변수 설정
ENV NODE_ENV=production
ENV PORT=3000

# 단계 4: 작업 디렉토리 설정
WORKDIR /app

# 단계 5: 의존성 파일 복사 (캐싱 최적화)
COPY package*.json ./

# 단계 6: 의존성 설치
RUN npm install --production

# 단계 7: 애플리케이션 소스 복사
COPY . .

# 단계 8: 포트 노출
EXPOSE 3000

# 단계 9: 건강 상태 검사 추가
HEALTHCHECK --interval=30s --timeout=3s \
  CMD node healthcheck.js

# 단계 10: 실행 명령
CMD ["node", "app.js"]