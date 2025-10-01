# 1단계: 베이스 이미지 선택
FROM nginx:alpine

# 2단계: HTML 파일 복사하기
COPY index.html /usr/share/nginx/html/

# 3단계: 웹서버 시작하기
CMD ["nginx", "-g", "daemon off;"]