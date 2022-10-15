package model;

public class Author {

      private String lastName;
      private String firstNane;


      public Author (String lastName, String firstNane) {
          setLastName(lastName);
          setFirstNane(firstNane);

      }

      public String getLastName() {
          return lastName;
      }

      public void setLastName(String lastName) {
          this.lastName = lastName;
      }

      public  String getFirstNane() {
          return firstNane;
      }

      public void  setFirstNane(String firstNane) {
          this.firstNane = firstNane;
      }
}
