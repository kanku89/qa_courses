package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactProfileTest extends TestBase {

  public static String clean(String profile) {
    return profile
        .replaceAll("\\s", "")
        .replaceAll("[-()]", "")
        .replaceAll("\n", "")
        .replaceAll("[HMWP]\\:", "");
  }

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().goHome();
    if (!app.getGeneralHelper().isThereAnElement()) {
      app.getContactHelper().createNewContact(new ContactData().withFirstName("Just").withLastName("Random").withAddress("Words").withMobile("Words").withMail("for@test.com"));
    }
  }

  @Test
  public void testContactProfile() {
    app.getNavigationHelper().goHome();
    ContactData contact = app.getContactHelper().all().iterator().next();
    ContactData contactInfo = app.getContactHelper().infoFromForm(contact);
    String contactProfileInfo = app.getContactHelper().infoFromProfile(contact);

    assertThat(cleanProfile(contactProfileInfo), equalTo(mergeProfile(contactInfo)));

  }

  private String mergeProfile(ContactData contact) {
    return Stream.of(contact.getFirstName(), contact.getLastName(), contact.getAddress(), contact.getHomePhone(),
        contact.getMobile(), contact.getMail(), contact.getMail2(), contact.getMail3(), contact.getAddress2(), contact.getWorkPhone())
        .map(ContactProfileTest::clean)
        .filter(s -> !s.equals("")).collect(Collectors.joining(""));
  }

  private String cleanProfile(String contact1) {
    return clean(contact1);
      }

}