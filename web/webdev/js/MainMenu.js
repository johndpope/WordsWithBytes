/**
 * Created by ross on 1/31/16.
 */

WordsWithBytes.MainMenu = function(game) {};

var button2;
var button3;
var button4;



WordsWithBytes.MainMenu.prototype = {

    create: function() {

        this.scale.fullScreenScaleMode = Phaser.ScaleManager.EXACT_FIT;

        var backgroundImage = this.add.sprite(this.game.world.centerX, this.game.world.centerY, 'space-background');
        backgroundImage.anchor.setTo(0.5, 0.5);

        var scoreFont = "65px Arial";
        var playerSelection = this.game.add.text(this.game.world.centerX, this.game.world.centerY / 4, "", {font: scoreFont, fill: "#ffffff", stroke: "#535353", strokeThickness: 15});
        playerSelection.anchor.set(0.5);

        button2 = this.game.add.button(this.game.world.centerX, this.game.world.centerY * (0.55), 'player2Button', playerTwoActionOnClick, this, 2, 1, 0);
        button2.anchor.setTo(0.5, 0.5);

        button3 = this.game.add.button(this.game.world.centerX, this.game.world.centerY, 'player3Button', playerThreeActionOnClick, this, 2, 1, 0);
        button3.anchor.setTo(0.5, 0.5);

        button4 = this.game.add.button(this.game.world.centerX, this.game.world.centerY * (1.45), 'player4Button', playerFourActionOnClick, this, 2, 1, 0);
        button4.anchor.setTo(0.5, 0.5);
    }
}

function playerTwoActionOnClick() {
    this.state.start("login");
}
function playerThreeActionOnClick() {
    this.state.start("login");
}
function playerFourActionOnClick() {
    this.state.start("login");
}