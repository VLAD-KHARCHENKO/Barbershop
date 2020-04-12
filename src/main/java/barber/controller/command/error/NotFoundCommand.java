package barber.controller.command.error;

import com.barber.controller.command.Command;
import com.barber.controller.data.Page;

import javax.servlet.http.HttpServletRequest;
import static com.barber.controller.PageUrlConstants.NOT_FOUND_PAGE;

public class NotFoundCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(NOT_FOUND_PAGE);
    }
}
