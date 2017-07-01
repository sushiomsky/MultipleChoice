/*
 * *
 *  * ${PROJECT_NAME}
 *  * Copyright (c) ${YEAR} Dennis Suchomsky <dennis.suchomsky@gmail.com>
 *  *
 *  *  This program is free software: you can redistribute it and/or modify
 *  *  it under the terms of the GNU General Public License as published by
 *  *  the Free Software Foundation, either version 3 of the License, or
 *  *  (at your option) any later version.
 *  *
 *  *  This program is distributed in the hope that it will be useful,
 *  *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  *  GNU General Public License for more details.
 *  *
 *  *  You should have received a copy of the GNU General Public License
 *  *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 * *
 *  @todo Keep it simple!
 * /
 */

package xyz.bitnaesser.multiplechoice.main;

import android.os.Bundle;
import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;
import nucleus5.presenter.Factory;
import nucleus5.presenter.RxPresenter;
import xyz.bitnaesser.multiplechoice.base.App;
import xyz.bitnaesser.multiplechoice.base.ServerAPI;

import static io.reactivex.android.schedulers.AndroidSchedulers.mainThread;
import static io.reactivex.schedulers.Schedulers.io;

public class MainPresenter extends RxPresenter<MainActivity> {

    public static final String NAME_1 = "Chuck Norris";
    public static final String NAME_2 = "Jackie Chan";
    public static final String DEFAULT_NAME = NAME_1;

    private static final int REQUEST_ITEMS = 1;

    private static final String NAME_KEY = MainPresenter.class.getName() + "#name";

    private String name = DEFAULT_NAME;

    @Override
    public void onCreate(Bundle savedState) {
        super.onCreate(savedState);

        if (savedState != null)
            name = savedState.getString(NAME_KEY);

        restartableLatestCache(REQUEST_ITEMS,
            new Factory<Observable<ServerAPI.Response>>() {
                @Override
                public Observable<ServerAPI.Response> create() {
                    return App.getServerAPI()
                        .getItems(name.split("\\s+")[0], name.split("\\s+")[1])
                        .subscribeOn(io())
                        .observeOn(mainThread());
                }
            },
            new BiConsumer<MainActivity, ServerAPI.Response>() {
                @Override
                public void accept(MainActivity activity, ServerAPI.Response response) throws Exception {
                    activity.onItems(response.items, name);
                }
            },
            new BiConsumer<MainActivity, Throwable>() {
                @Override
                public void accept(MainActivity activity, Throwable throwable) throws Exception {
                    activity.onNetworkError(throwable);
                }
            });

        if (savedState == null)
            start(REQUEST_ITEMS);
    }

    @Override
    public void onSave(@NonNull Bundle state) {
        super.onSave(state);
        state.putString(NAME_KEY, name);
    }

    public void request(String name) {
        this.name = name;
        start(REQUEST_ITEMS);
    }
}
