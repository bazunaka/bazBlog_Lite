package ru.bazunaka.bazbloglite.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.bazunaka.bazbloglite.Model.TweetAddRequest;
import ru.bazunaka.bazbloglite.Model.TweetResponse;
import ru.bazunaka.bazbloglite.Usecase.TweetAddUsecase;

@RestController
@RequestMapping("/api/v1/tweets")
public class TweetController {

    private final TweetAddUsecase tweetAddUsecase;

    public TweetController(TweetAddUsecase tweetAddUsecase) {
        this.tweetAddUsecase = tweetAddUsecase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TweetResponse addTweet(@Valid  @RequestBody TweetAddRequest addRequest) {
        return this.tweetAddUsecase.addTweet(addRequest);
    }
}
