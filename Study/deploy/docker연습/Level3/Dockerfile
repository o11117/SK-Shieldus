# Node.js 런타임 사용
FROM node:22.20.0-slim

# 컨테이너 내부 작업 폴더
WORKDIR /app

# 1. package.json 먼저 복사 (캐싱 활용)
COPY package.json .

# 2. 필요한 패키지 설치
RUN npm install

# 3. 나머지 파일들 복사
COPY . .

# 4. 환경 변수 설정
ENV NODE_ENV=production
ENV PORT=3000

# 5. 포트 열기
EXPOSE 3000

# 6. 앱 실행
CMD ["node", "app.js"]