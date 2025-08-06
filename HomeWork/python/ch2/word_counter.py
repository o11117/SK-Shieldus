print('문장을 입력하세요:')
sentence = input()
print(f'공백 제거: {' '.join(sentence.split())}\n단어 개수: {len(sentence.split())}')