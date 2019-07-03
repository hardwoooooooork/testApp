import React from 'react';
import { render } from '@testing-library/react';
import Map from '../components/Maps';


describe('<Map />', () => {
    it('matches snapshot', () => {
        const utils = render(<Map />);
        expect(utils.container).toMatchSnapshot();
    });
});