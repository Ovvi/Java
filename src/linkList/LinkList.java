package linkList;

/**
 * Created by Ovi on 11/9/2016.
 */
public class LinkList {

    public String bookName;
    public int sold;
    public LinkList next;

    public LinkList(String bookName, int sold) {
        this.bookName = bookName;
        this.sold = sold;
    }

    public void display() {
        System.out.println(bookName + " : " + sold + " sold");
    }

    public String toString() {
        return bookName;
    }

    public static void main(String[] args) {
        LinkListTest linkList = new LinkListTest();
        /*
        linkList.insertFirstLink("First book",324);
        linkList.insertFirstLink("Second book",215);
        linkList.insertFirstLink("Third book",174);
        linkList.display();
        System.out.println(linkList.find("Second book")+ " was found");
        linkList.removeLink("First book");
        linkList.remove();
        linkList.display();
        */


    }
}




class LinkListTest {
    LinkList firstLink;

    public LinkListTest() {
        firstLink = null;
    }

    public boolean isEmpty() {
        return (firstLink == null);
    }

    public void insertFirstLink(String bookName, int sold) {
        LinkList newLink = new LinkList(bookName, sold);
        newLink.next = firstLink;
        firstLink = newLink;
    }

    public void remove() {
        if (!isEmpty()) {
            firstLink = firstLink.next;
        } else {
            System.out.println("The list is empty");
        }
    }

    public void display() {
        LinkList theLink = firstLink;

        while (theLink != null) {
            theLink.display();
            System.out.println("The next link is : " + theLink.next);
            theLink = theLink.next;
            System.out.println();
        }
    }

    public LinkList find(String bookName) {
        LinkList theLink = firstLink;

        if (!isEmpty()) {
            while (theLink.bookName != bookName) {
                if (theLink.next == null) {
                    return null;
                } else {
                    theLink = theLink.next;
                }
            }
        } else {
            System.out.println("The list is empty");
        }

        return theLink;
    }

    public void removeLink(String bookName) {
        LinkList currentLink = firstLink;
        LinkList previousLink = firstLink;

        if (!isEmpty()) {
            while (currentLink.bookName != bookName) {
                if (currentLink.next == null) {
                    break;
                } else {
                    previousLink = currentLink;
                    currentLink = currentLink.next;
                }
            }

            if (currentLink == firstLink) {
                firstLink = firstLink.next;
            }

            if (currentLink.bookName == bookName) {
                System.out.println("The link " + currentLink.bookName + " was found and removed");
                previousLink.next = currentLink.next;
            } else {
                System.out.println("The link was not found");
            }
        } else {
            System.out.println("The list is empty");
        }
    }

}


























