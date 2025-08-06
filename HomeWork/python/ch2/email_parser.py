print('이메일 주소를 입력하세요:')
email = input()
print(f'사용자명: {email.split('@')[0]}\n도메인: {email.split('@')[1]}')