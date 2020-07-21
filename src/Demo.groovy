@Grapes([
        @Grab("org.gebish:geb-core:3.4"),
        @Grab("org.seleniumhq.selenium:selenium-firefox-driver:3.141.59"),
        @Grab("org.seleniumhq.selenium:selenium-support:3.141.59")
])
import geb.Browser


Browser.drive {
    go "http://gebish.org"

    assert title == "Geb - Very Groovy Browser Automation"

    $("div.menu a.manuals").click()
    waitFor { !$("#manuals-menu").hasClass("animating") }

    $("#manuals-menu a")[0].click()

    assert title.startsWith("The Book Of Geb")
}
