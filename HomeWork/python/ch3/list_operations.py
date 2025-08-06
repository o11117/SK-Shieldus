list1 = [1, 2, 3, 4, 5]
list2 = [4, 5, 6, 7, 8]
print(f'리스트1: {list1}\n리스트2: {list2}\n병합된 리스트: {list1 + list2}\n공통 요소: {list(set(list1) & set(list2))}')