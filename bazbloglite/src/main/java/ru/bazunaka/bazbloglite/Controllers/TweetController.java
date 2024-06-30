package ru.bazunaka.bazbloglite.Controllers;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Model.TweetAddRequest;
import ru.bazunaka.bazbloglite.Model.TweetEditRequest;
import ru.bazunaka.bazbloglite.Model.TweetFindRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Usecase.TweetAddCase;
import ru.bazunaka.bazbloglite.Usecase.TweetDeleteCase;
import ru.bazunaka.bazbloglite.Usecase.TweetEditCase;
import ru.bazunaka.bazbloglite.Usecase.TweetFindCase;

import java.util.Collection;

/**
 * Контроллер для управления твитами.
 * Обрабатывает HTTP-запросы, связанные с добавлением, редактированием, удалением и поиском твитов.
 */
@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddCase tweetAddCase;
    private final TweetEditCase tweetEditCase;
    private final TweetDeleteCase tweetDeleteCase;
    private final TweetFindCase tweetFindCase;

    /**
     * Конструктор контроллера твитов.
     *
     * @param tweetAddCase    компонент для добавления твитов
     * @param tweetEditCase   компонент для редактирования твитов
     * @param tweetDeleteCase компонент для удаления твитов
     * @param tweetFindCase   компонент для поиска твитов
     */
    public TweetController(TweetAddCase tweetAddCase,
            TweetEditCase tweetEditCase,
            TweetDeleteCase tweetDeleteCase,
            TweetFindCase tweetFindCase) {
        this.tweetAddCase = tweetAddCase;
        this.tweetEditCase = tweetEditCase;
        this.tweetDeleteCase = tweetDeleteCase;
        this.tweetFindCase = tweetFindCase;
    }

    /**
     * Обрабатывает POST-запрос для добавления нового твита.
     *
     * @param addRequest запрос на добавление твита
     * @return ответ с информацией о добавленном твите
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid @RequestBody TweetAddRequest addRequest) {
        return this.tweetAddCase.addTweet(addRequest);
    }

    /**
     * Обрабатывает PUT-запрос для редактирования существующего твита.
     *
     * @param editRequest запрос на редактирование твита
     * @return ответ с информацией о редактированном твите
     */
    @PutMapping
    public TweetResponse editTweet(@Valid @RequestBody TweetEditRequest editRequest) {
        return this.tweetEditCase.editTweet(editRequest);
    }

    /**
     * Обрабатывает DELETE-запрос для удаления твита по его идентификатору.
     *
     * @param tweetId идентификатор твита для удаления
     */
    @DeleteMapping("/{tweetId}")
    public void deleteTweet(@PathVariable long tweetId) {
        this.tweetDeleteCase.deleteTweet(tweetId);
    }

    /**
     * Обрабатывает GET-запрос для поиска твитов владельца.
     *
     * @param page  номер страницы результатов
     * @param limit количество твитов на странице
     * @return коллекция твитов владельца
     */
    @GetMapping
    public Collection<TweetResponse> findOwnerTweets(@PathParam("page") int page, @PathParam("limit") int limit) {
        TweetFindRequest findRequest = new TweetFindRequest(page, limit);
        return this.tweetFindCase.findTweets(findRequest);
    }
}
