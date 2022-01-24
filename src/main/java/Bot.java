import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import java.util.*;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
    protected Bot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotUsername() {
        return "room502bot";
    }

    @Override
    public String getBotToken() {
        return "2078032358:AAFIZAF6z29NhfQGpUr2kwrILsru9SnOyTc";
    }
    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
         if(update.hasCallbackQuery()){
             handleCallback(update.getCallbackQuery());
         } else
          if(update.hasMessage())
          {
             handleMessage(update.getMessage());
          }
    }
    @SneakyThrows
    private void handleCallback(CallbackQuery callbackQuery) {
        FotoContainer fotoContainer = new FotoContainer();
        Message message = callbackQuery.getMessage();
        String[] location = callbackQuery.getData().split(":");
        String floor = location[0];
        String room = location[1];
        switch (floor){
            case "1Floor":
            switch (room)
            {case "Душик":
                execute(SendPhoto.builder().photo(fotoContainer.get("shower")).caption(PropUtil.getProperty("ShowerDescription")).chatId(message.getChatId().toString()).build());
                break;
                case "Теннис":execute(SendPhoto.builder().photo(fotoContainer.get("Tennis")).caption(PropUtil.getProperty("TennisDescription")).chatId(message.getChatId().toString()).build());
                break;
                case "Дежурка":execute(SendPhoto.builder().photo(fotoContainer.get("Duty")).caption(PropUtil.getProperty("DutyDescription")).chatId(message.getChatId().toString()).build());
                break;
                case "Холл":
                    execute(SendPhoto.builder().photo(fotoContainer.get("Hall")).caption(PropUtil.getProperty("HallDescription")).chatId(message.getChatId().toString()).build());
                    execute(SendPhoto.builder().photo(fotoContainer.get("Administration")).chatId(message.getChatId().toString()).build());
                break;
            } break;
            case "2Floor":
                switch (room)
                {case "Кухня":
                    execute(SendPhoto.builder().photo(fotoContainer.get("fk")).caption(PropUtil.getProperty("SecondKitchenDescription")).chatId(message.getChatId().toString()).build());
                    break;
                    case "Умывальники":execute(SendPhoto.builder().photo(fotoContainer.get("fb")).caption(PropUtil.getProperty("SecondWashRoomDescription")).chatId(message.getChatId().toString()).build());
                        break;
                    case "Коридор_право":execute(SendPhoto.builder().photo(fotoContainer.get("frc")).caption(PropUtil.getProperty("SecondLeftCorridor")).chatId(message.getChatId().toString()).build());
                        break;
                    case "Коридор_лево":
                        execute(SendPhoto.builder().photo(fotoContainer.get("lrc")).caption(PropUtil.getProperty("SecondRightCorridor")).chatId(message.getChatId().toString()).build());
                        break;
                } break;
            case "3Floor":
                switch (room)
            {case "Кухня":
                execute(SendPhoto.builder().photo(fotoContainer.get("sk")).caption(PropUtil.getProperty("ThirdKitchenDescription")).chatId(message.getChatId().toString()).build());
                break;
                case "Умывальники":execute(SendPhoto.builder().photo(fotoContainer.get("sb")).caption(PropUtil.getProperty("ThirdWashRoomDescription")).chatId(message.getChatId().toString()).build());
                    break;
                case "Коридор_право":execute(SendPhoto.builder().photo(fotoContainer.get("src")).caption(PropUtil.getProperty("ThirdLeftCorridor")).chatId(message.getChatId().toString()).build());
                    break;
                case "Коридор_лево":
                    execute(SendPhoto.builder().photo(fotoContainer.get("slc")).caption(PropUtil.getProperty("ThirdRightCorridor")).chatId(message.getChatId().toString()).build());
                    break;
            } break;
            case "4Floor":
                execute(SendMessage.builder().text(PropUtil.getProperty("FourthFloorDescription")).chatId(message.getChatId().toString()).build());
                switch (room)
            {case "Кухня":
                    execute(SendPhoto.builder().photo(fotoContainer.get("tk")).caption(PropUtil.getProperty("FourthKitchenDescription")).chatId(message.getChatId().toString()).build());
                    break;
                case "Умывальники":execute(SendPhoto.builder().photo(fotoContainer.get("tb")).caption(PropUtil.getProperty("FourthWashRoomDescription")).chatId(message.getChatId().toString()).build());
                    break;
                case "Коридор_право":execute(SendPhoto.builder().photo(fotoContainer.get("trc")).caption(PropUtil.getProperty("FourthLeftCorridor")).chatId(message.getChatId().toString()).build());
                    break;
                case "Коридор_лево":
                    execute(SendPhoto.builder().photo(fotoContainer.get("tlc")).caption(PropUtil.getProperty("FourthRightCorridor")).chatId(message.getChatId().toString()).build());
                    break;
            } break;
            case "5Floor":
                execute(SendMessage.builder().text(PropUtil.getProperty("FifthFloorDescription")).chatId(message.getChatId().toString()).build());
                switch (room)
            {case "Кухня":
                execute(SendPhoto.builder().photo(fotoContainer.get("lk")).caption(PropUtil.getProperty("FifthKitchenDescription")).chatId(message.getChatId().toString()).build());
                break;
                case "Умывальники":execute(SendPhoto.builder().photo(fotoContainer.get("lb")).caption(PropUtil.getProperty("FifthWashRoomDescription")).chatId(message.getChatId().toString()).build());
                    break;
                case "Коридор_право":execute(SendPhoto.builder().photo(fotoContainer.get("lrc")).caption(PropUtil.getProperty("FifthRightCorridor")).chatId(message.getChatId().toString()).build());
                    break;
                case "Коридор_лево":
                    execute(SendPhoto.builder().photo(fotoContainer.get("llc")).caption(PropUtil.getProperty("FifthLeftCorridor")).chatId(message.getChatId().toString()).build());
                    break;
            } break;
        }
    }

    @SneakyThrows
    private void handleMessage(Message message) {
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity = message.getEntities().stream().filter(e -> "bot_command".equals(e.getType())).findFirst();

        if (commandEntity.isPresent()) {
            String command = message.getText().substring(commandEntity.get().getOffset(),commandEntity.get().getLength());
            switch (command)
            {case "/floor1":
                List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
                for (val vll: val.values()){
                    buttons.add(Arrays.asList(InlineKeyboardButton.builder().
                            text(vll.name()).callbackData("1Floor:"+vll.name()).build()));
                }
                    execute(SendMessage.builder().text("А куда именно?").
                        chatId(message.getChatId().toString())
                        .replyMarkup(InlineKeyboardMarkup.builder().keyboard(buttons).build())
                        .build());
                    break;
                case "/floor2":
                    List<List<InlineKeyboardButton>> fl = new ArrayList<>();
                    for (loc vll: loc.values()){
                        fl.add(Arrays.asList(InlineKeyboardButton.builder().
                                text(vll.name()).callbackData("2Floor:"+vll.name()).build()));
                    }
                    execute(SendMessage.builder().text("А куда именно?").
                            chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder().keyboard(fl).build())
                            .build());
                     break;
                case "/floor3":
                    List<List<InlineKeyboardButton>> fl3 = new ArrayList<>();
                    for (loc vll: loc.values()){
                        fl3.add(Arrays.asList(InlineKeyboardButton.builder().
                                text(vll.name()).callbackData("3Floor:"+vll.name()).build()));
                    }
                    execute(SendMessage.builder().text("А куда именно?").
                            chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder().keyboard(fl3).build())
                            .build());
                    break;
                case "/floor4":  List<List<InlineKeyboardButton>> fl4 = new ArrayList<>();
                    for (loc vll: loc.values()){
                        fl4.add(Arrays.asList(InlineKeyboardButton.builder().
                                text(vll.name()).callbackData("4Floor:"+vll.name()).build()));
                    }
                    execute(SendMessage.builder().text("А куда именно?").
                            chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder().keyboard(fl4).build())
                            .build());
                    break;
                case "/floor5": List<List<InlineKeyboardButton>> fl5 = new ArrayList<>();
                    for (loc vll: loc.values()){
                        fl5.add(Arrays.asList(InlineKeyboardButton.builder().
                                text(vll.name()).callbackData("5Floor:"+vll.name()).build()));
                    }
                    execute(SendMessage.builder().text("А куда именно?").
                            chatId(message.getChatId().toString())
                            .replyMarkup(InlineKeyboardMarkup.builder().keyboard(fl5).build())
                            .build());
                    break;

            }}

        }
    }


}
