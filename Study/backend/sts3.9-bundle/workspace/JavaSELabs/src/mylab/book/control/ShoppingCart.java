package mylab.book.control;

import mylab.book.entity.Magazine;
import mylab.book.entity.Novel;
import mylab.book.entity.Publication;
import mylab.book.entity.ReferenceBook;

import java.util.List;

public class ShoppingCart {
    private List<Publication> items;

    ShoppingCart() {
        this.items = new java.util.ArrayList<>();
    }
    public void addItem(Publication item) {
        items.add(item); System.out.println(item.getTitle() + "이(가) 장바구니에 추가되었습니다.");
    }

    public boolean removeItem(String title) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getTitle().equals(title)) {
                Publication removed = items.remove(i);
                System.out.println(removed.getTitle() + "이(가) 장바구니에서 제거되었습니다.");
                return true; // 성공적으로 제거됨
            }
        }
        System.out.println("해당 제목의 출판물을 찾을 수 없습니다.");
        return false; // 제거 실패
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("장바구니가 비어 있습니다.");
        } else {
            System.out.println("장바구니에 담긴 책 목록:");
            int totalPrice = 0;
            int discountedPrice = 0;
            for (Publication item : items) {
                System.out.println(item);
            }
            System.out.println("총 가격: " + calculateTotalPrice());
            System.out.println("할인 적용 가격: " + calculateDiscountedPrice());
        }
    }

    public int calculateTotalPrice() {
        int totalPrice = 0;
        for (Publication item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public int calculateDiscountedPrice() {
        int total = 0;
        for (Publication item : items) {
            // ManageBook과는 다른 할인율 적용 (용도별 차별화)
            if (item instanceof Magazine) {
                total += item.getPrice() * 0.9; // 10% 할인
            } else if (item instanceof Novel) {
                total += item.getPrice() * 0.85; // 15% 할인
            } else if (item instanceof ReferenceBook) {
                total += item.getPrice() * 0.8; // 20% 할인
            } else {
                total += item.getPrice(); // 기본 출판물은 할인 없음
            }
        }
        return total;
    }

    public void printStatistics() {
        int magazineCount = 0;
        int novelCount = 0;
        int referenceBookCount = 0; // instanceof를 활용한 타입별 카운팅
        for (Publication item : items) {
            if (item instanceof Magazine) {
                magazineCount++;
            } else if (item instanceof Novel) {
                novelCount++;
            } else if (item instanceof ReferenceBook) {
                referenceBookCount++;
            }
        }
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 출판물 추가
        cart.addItem(new Magazine("마이크로소프트", "2007-10-01", 328, 9900, "매월"));
        cart.addItem(new Magazine("경영과컴퓨터", "2007-10-03", 316, 9000, "매월"));
        cart.addItem(new Novel("남한산성", "2007-04-14", 383, 11000, "김훈", "대하소설"));
        cart.addItem(new Novel("빠삐용", "2007-07-01", 396, 9800, "베르나르베르베르", "현대소설"));
        cart.addItem(new ReferenceBook("실용주의프로그래머", "2007-01-14", 496, 25000, "소프트웨어공학"));

        // 장바구니 내용 출력
        cart.displayCart();

        cart.printStatistics();
        // 특정 출판물 제거
        cart.removeItem("빠삐용");

        // 장바구니 내용 다시 출력
        cart.displayCart();

}

    }
