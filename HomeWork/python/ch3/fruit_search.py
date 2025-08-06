fruits = ['사과','바나나','오렌지','포도','딸기']
print(f'과일 목록: {fruits}\n검색할 과일을 입력하세요:')
fruit = input()
print(f"'{fruit}'가 목록에 있습니다" if fruit in fruits else f"'{fruit}'가 목록에 없습니다")