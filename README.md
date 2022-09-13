# Android Project 1 - *Wordle-ish*

Submitted by: **Fernando Sckaff**

**Wordle-ish** is an android app that recreates a simple version of the popular word game [Wordle](https://www.nytimes.com/games/wordle/index.html). 

Time spent: **5** hours spent in total

## Required Features

The following **required** functionality is completed:

- [X] **User has 3 chances to guess a random 4 letter word**
- [X] **After 3 guesses, user should no longer be able to submit another guess**
- [X] **After each guess, user sees the "correctness" of the guess**
- [X] **After all guesses are taken, user can see the target word displayed**

The following **optional** features are implemented:

- [ ] User can toggle between different word lists
- [ ] User can see the 'correctness' of their guess through colors on the word 
- [X] User sees a visual change after guessing the correct word
- [X] User can tap a 'Reset' button to get a new word and clear previous guesses
- [X] User will get an error message if they input an invalid guess
- [ ] User can see a 'streak' record of how many words they've guessed correctly.

The following **additional** features are implemented:

* [X] Change the app theme color

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='bbbbb.gif' title='Video Walkthrough' width='300' alt='Video Walkthrough' />

GIF created with [MNML Screen Recorder](https://play.google.com/store/apps/details?id=easy.screenrecord)

## Notes

I don't like repeating variable declarations everytime I make a new function. However, I couldn't put variables on MainActivity() besides the "wordToGuess" variable. So I had to repeaat a few variables.

Additionally, I had to record on my phone as my virtual emulator does not work properly.

Finally, I wasn't able to win on the GIF walkthrough, but there is a little toast celebration if you win.

## License

    Copyright [2022] [Fernando Sckaff]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.