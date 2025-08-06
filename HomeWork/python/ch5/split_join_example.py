or_str = 'Python is awesome programming language'
or_list = or_str.split()
hy = '-'.join(or_list)
upper = or_str.upper()

print(f'원본 문자열: {or_str}\n분리된 단어들: {or_list}\n하이픈으로 연결: {hy}\n대문자로 변환 후 공백으로 연결: {upper}')