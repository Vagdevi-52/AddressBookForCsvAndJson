package AddressBookForCsvAndJson;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TestAddressBookCSV
{

	@Test
	public void given3ContactsWhenWrittenToCSVFileShouldMatchContactEntries() //csv file.
	{
		Contacts jeff=new Contacts("Amedkar","gandhji","Ame@gmail.com","San Francisco","Address","189675","California","+23-1234567890");
		Contacts mark=new Contacts("prabhas","nehru","prabhas@gmail.com","New York ","Address","016483","New York","+12-9874563210");
		Contacts satya=new Contacts("guru", "gopaldas","satya@gmail.com","Los Angeles","Address","987324","California","+11-5463217890");
		List<Contacts> contacts=Arrays.asList(new Contacts[] {jeff, mark, satya});
		AddressBookCSV addressBookCSVIOService=new AddressBookCSV("addressCsvTest.csv");
		addressBookCSVIOService.writeContactDetailsInAFile(contacts);
		List<Contacts> readContacts=addressBookCSVIOService.readAddressBookFromAFile();
		assertEquals(jeff.toString(),readContacts.get(0).toString());
		assertEquals(mark.toString(),readContacts.get(1).toString());
		assertEquals(satya.toString(),readContacts.get(2).toString());
	}
}