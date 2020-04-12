package barber.controller.command.info;

import com.barber.controller.command.Command;
import com.barber.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.barber.controller.PageUrlConstants.CONTACT_PAGE;

public class ContactCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(CONTACT_PAGE);
    }
}
