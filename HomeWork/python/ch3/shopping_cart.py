shopping_cart = {}
def add_item(item, price, quantity=1):
    if item in shopping_cart:
        shopping_cart[item]['quantity'] += quantity
    else:
        shopping_cart[item] = {'price': price, 'quantity': quantity}

def get_total():
    return sum(info['price'] * info['quantity'] for info in shopping_cart.values())

add_item('사과', 1000, 2)
add_item('바나나', 800, 3)
add_item('오렌지', 1500, 1)

print('쇼핑 카트:')
for item, info in shopping_cart.items():
    print(f'{item}: {info["quantity"]}개 = {info["price"] * info["quantity"]}원')
print(f'총 금액: {get_total()}원')
