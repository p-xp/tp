package wedlog.address.storage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static wedlog.address.testutil.Assert.assertThrows;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import wedlog.address.commons.exceptions.IllegalValueException;
import wedlog.address.commons.util.JsonUtil;
import wedlog.address.model.AddressBook;
import wedlog.address.testutil.TypicalPersons;
import wedlog.address.testutil.TypicalVendors;

public class JsonSerializableAddressBookTest {

    private static final Path TEST_DATA_FOLDER = Paths.get("src", "test", "data", "JsonSerializableAddressBookTest");
    private static final Path TYPICAL_PERSONS_FILE = TEST_DATA_FOLDER.resolve("typicalPersonsAddressBook.json");
    private static final Path INVALID_PERSON_FILE = TEST_DATA_FOLDER.resolve("invalidPersonAddressBook.json");
    private static final Path DUPLICATE_PERSON_FILE = TEST_DATA_FOLDER.resolve("duplicatePersonAddressBook.json");
    private static final Path TYPICAL_GUESTS_FILE = TEST_DATA_FOLDER.resolve("typicalGuestsAddressBook.json");
    private static final Path INVALID_GUEST_FILE = TEST_DATA_FOLDER.resolve("invalidGuestAddressBook.json");
    private static final Path DUPLICATE_GUEST_FILE = TEST_DATA_FOLDER.resolve("duplicateGuestAddressBook.json");
    private static final Path TYPICAL_VENDORS_FILE = TEST_DATA_FOLDER.resolve("typicalVendorsAddressBook.json");
    private static final Path INVALID_VENDOR_FILE = TEST_DATA_FOLDER.resolve("invalidVendorAddressBook.json");
    private static final Path DUPLICATE_VENDOR_FILE = TEST_DATA_FOLDER.resolve("duplicateVendorAddressBook.json");

    @Test
    public void toModelType_typicalPersonsFile_success() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_PERSONS_FILE,
                JsonSerializableAddressBook.class).get();
        AddressBook addressBookFromFile = dataFromFile.toModelType();
        AddressBook typicalPersonsAddressBook = TypicalPersons.getTypicalAddressBook();
        assertEquals(addressBookFromFile, typicalPersonsAddressBook);
    }

    @Test
    public void toModelType_invalidPersonFile_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_PERSON_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicatePersons_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_PERSON_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableAddressBook.MESSAGE_DUPLICATE_PERSON,
                dataFromFile::toModelType);
    }

    // guests-test

    @Test
    public void toModelType_invalidGuestFile_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_GUEST_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicateGuests_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_GUEST_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableAddressBook.MESSAGE_DUPLICATE_GUEST,
                dataFromFile::toModelType);
    }

    // vendors-test

    @Test
    public void toModelType_typicalVendorsFile_success() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(TYPICAL_VENDORS_FILE,
                JsonSerializableAddressBook.class).get();
        AddressBook addressBookFromFile = dataFromFile.toModelType();
        AddressBook typicalVendorsAddressBook = TypicalVendors.getTypicalAddressBook();
        assertEquals(addressBookFromFile, typicalVendorsAddressBook);
    }

    @Test
    public void toModelType_invalidVendorFile_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(INVALID_VENDOR_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, dataFromFile::toModelType);
    }

    @Test
    public void toModelType_duplicateVendors_throwsIllegalValueException() throws Exception {
        JsonSerializableAddressBook dataFromFile = JsonUtil.readJsonFile(DUPLICATE_VENDOR_FILE,
                JsonSerializableAddressBook.class).get();
        assertThrows(IllegalValueException.class, JsonSerializableAddressBook.MESSAGE_DUPLICATE_VENDOR,
                dataFromFile::toModelType);
    }
}
