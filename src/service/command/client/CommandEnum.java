/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.command.client;

import service.command.DeleteBookingCommand;
import service.command.DeleteUserCommand;
import service.command.LogOutCommand;
import service.command.LoginCommand;
import service.command.MoveAwayCommand;
import service.command.NewBookingCommand;
import service.command.PaymentCommand;
import service.command.SaveNewUserCommand;
import service.command.SendBookCommand;
import service.command.BaseCommandI;
import service.command.RegistrationCommand;

/**
 *
 * @author Женя
 */
public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    }, LOGOUT {
        {
            this.command = new LogOutCommand();
        }

    }, DELETEUSER {
        {
            this.command = new DeleteUserCommand();
        }
    }, DELETEBOOKING {
        {
            this.command = new DeleteBookingCommand();
        }

    }, REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    }, SENDBOOK {
        {
            this.command = new SendBookCommand();
        }
    }, NEWBOOKING {

        {
            this.command = new NewBookingCommand();
        }

    }, MOVEAWAY {
        {
            this.command = new MoveAwayCommand();
        }

    }, PAYMENT {
        {
            this.command = new PaymentCommand();
        }

    }, SAVE {
        {
            this.command = new SaveNewUserCommand();
        }

    };

    BaseCommandI command;

    public BaseCommandI getCurrentCommand() {
        return command;
    }
}
