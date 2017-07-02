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

package xyz.bitnaesser.multiplechoice.util;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by sushi on 02.07.17.
 */

public class getJsonFromFile {

	public static String loadJSONFromAsset(InputStream is) {
		String json = null;
		try {
			int size = is.available();

			byte[] buffer = new byte[size];

			is.read(buffer);

			is.close();

			json = new String(buffer, "UTF-8");


		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		}
		return json;

	}
}
