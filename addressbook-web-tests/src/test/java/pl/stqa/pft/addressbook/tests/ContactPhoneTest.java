package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goHome();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData().withFirstName("Just").withLastName("Random").withAddress("Words").withMobile("Words").withMail("for@test.com"));
    }
  }

  @Test
  public void testContactPhones() {
    app.getNavigationHelper().goHome();
    ContactData contact = app.getContactHelper().all().iterator().next();
    ContactData contactInfo = app.getContactHelper().infoFromForm(contact);

    assertThat(contact.getAllMails(), equalTo(mergeMails(contactInfo)));
    assertThat(contact.getAddress(), equalTo(contactInfo.getAddress()));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfo)));

  }

  public static String clean(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String mergePhones(ContactData contact) {
    return Stream.of(contact.getHomePhone(), contact.getMobile(), contact.getWorkPhone())
        .map(ContactPhoneTest::clean)
        .filter(s -> !s.equals("")).collect(Collectors.joining("\n"));
  }

  private String mergeMails(ContactData contact) {
    return Stream.of(contact.getMail(), contact.getMail2(), contact.getMail3())
        .filter(s -> !s.equals("")).collect(Collectors.joining("\n"));
  }

}
