from collections import Counter

def count_word_frequency(file_path):
    with open(file_path, 'r', encoding='utf-8') as f:
        text = f.read()
    words = text.split()
    freq = Counter(words)
    return freq


freq = count_word_frequency('example2.txt')
print('단어 빈도 분석 결과:')
for word, count in freq.items():
    print(f'{word}: {count}번')
