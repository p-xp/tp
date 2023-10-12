package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.VendorDeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses user input specifically for GuestDelete commands.
 */
public class GuestDeleteCommandParser implements Parser<VendorDeleteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public VendorDeleteCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new VendorDeleteCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, VendorDeleteCommand.MESSAGE_USAGE), pe);
        }
    }
}
