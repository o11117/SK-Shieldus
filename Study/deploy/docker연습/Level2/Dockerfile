FROM nginx:alpine

# 작업 디렉토리 설정 (선택사항)
WORKDIR /usr/share/nginx/html

# 여러 파일 복사
COPY index.html .
COPY style.css .
COPY images/ ./images/

# 포트 알리기 (실제로 열지는 않지만 문서화)
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]